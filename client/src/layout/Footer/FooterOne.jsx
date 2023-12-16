import React, { useState } from "react";
import { Link } from "react-router-dom";
import { LambdaClient, InvokeCommand, LogType } from "@aws-sdk/client-lambda"; // ES Modules import
import { Button, Form, Input, notification } from "antd";
const { fromTemporaryCredentials } = require("@aws-sdk/credential-providers");

const FooterOne = ({ footerLight, style, footerGradient }) => {
  const [api, contextHolder] = notification.useNotification();
  const [form] = Form.useForm();
  const AWS = require("aws-sdk");

  AWS.config.update({
    accessKeyId: "YOURKEY",
    secretAccessKey: "YOURSECRET",
  });

  const handleSubmit = async (event) => {
    event.preventDefault();

    const credentials = await fromTemporaryCredentials({
      params: {
        RoleArn: "arn:aws:lambda:us-east-1:401532472896:function:email-submit",
      },
      clientConfig: {
        region: "us-west-2",
      },
    })();

    try {
      const client = new LambdaClient({
        region: "us-west-2",
        credentials,
      });

      const command = new InvokeCommand({
        FunctionName: "email-submit",
        Payload: JSON.stringify("payload"),
        LogType: LogType.Tail,
      });

      const { Payload, LogResult } = await client.send(command);
      const result = Buffer.from(Payload).toString();
      const logs = Buffer.from(LogResult, "base64").toString();
      return { logs, result };
    } catch (error) {
      console.error("Error invoking function:", error);
      // Handle errors as needed
    }
  };

  const handleFormSubmit = async (formValues) => {
    console.log(formValues);

    try {
      api.success({ message: "Form was submited successfully" });
      form.resetFields();
    } catch (error) {}
  };

  return (
    <>
      {contextHolder}
      CONTROLLED FORM
      <Form onFinish={handleFormSubmit} className="form" form={form}>
        <Form.Item
          name={"email"}
          hasFeedback
          rules={[
            {
              required: true,
              type: "email",
              message: "Please use a valid email",
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Button type="primary" htmlType="submit">
          Subscribe
        </Button>
      </Form>
      OLD FORM
      <form
        className="newsletter-form position-relative d-block d-lg-flex d-md-flex"
        onSubmit={handleSubmit}
      >
        <input
          type="text"
          className="input-newsletter form-control me-2"
          placeholder="Enter your email"
          name="email"
          required={true}
          autoComplete="off"
        />
        <input
          type="submit"
          value="Subscribe"
          data-wait="Please wait..."
          className="btn btn-primary mt-3 mt-lg-0 mt-md-0"
        />
      </form>
    </>
  );
};

export default FooterOne;
