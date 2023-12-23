import React, { useState } from "react";
import { Button, Form, Input, notification } from "antd";

const FooterOne = ({ footerLight, style, footerGradient }) => {
  const [api, contextHolder] = notification.useNotification();
  const [form] = Form.useForm();

  const [response, setResponse] = useState("");

  const handleFormSubmit = async (formValues) => {
    const { email } = formValues;

    const body = {
      email,
    };

    try {
      const result = await fetch(
        `https://s7mvanfyy7726dco5yzt3emmsq0zeswn.lambda-url.us-east-1.on.aws/}`,
        {
          method: "POST",
          body: JSON.stringify(body),
        }
      );

      const response = await result.text();

      setResponse(response);

      api.success({ message: "Form was submited successfully" });
      form.resetFields();
    } catch (error) {
      api.error({ message: error.message });
      form.resetFields();
    }
  };

  return (
    <>
      {contextHolder}
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

      {response && (
        <>
          <p>Lambda Response</p>
          <h1>{response}</h1>
        </>
      )}
    </>
  );
};

export default FooterOne;
