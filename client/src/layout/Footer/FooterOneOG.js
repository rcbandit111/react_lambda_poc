import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import {LambdaClient, InvokeCommand, LogType} from "@aws-sdk/client-lambda"; // ES Modules import
const { fromTemporaryCredentials } = require("@aws-sdk/credential-providers");


const FooterOne = ({ footerLight, style, footerGradient }) => {

  const AWS = require('aws-sdk');

  AWS.config.update({
    accessKeyId: "AKIAV27JTJZAHWU6N67I",
    secretAccessKey: "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"
  });


  const handleSubmit = async (event) => {
    event.preventDefault();

    const credentials = await fromTemporaryCredentials({
      params: {
        RoleArn: "arn:aws:lambda:us-east-1:401532472896:function:email-submit",
      },
      clientConfig: {
        region: 'us-west-2',
      },
    })();

    try {
      const client = new LambdaClient({
        region: 'us-west-2',
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
      console.error('Error invoking function:', error);
      // Handle errors as needed
    }
  };

  return (
      <>
        <form className='newsletter-form position-relative d-block d-lg-flex d-md-flex' onSubmit={handleSubmit}>
          <input
              type='text'
              className='input-newsletter form-control me-2'
              placeholder='Enter your email'
              name='email'
              required=''
              autoComplete='off'
          />
          <input
              type='submit'
              value='Subscribe'
              data-wait='Please wait...'
              className='btn btn-primary mt-3 mt-lg-0 mt-md-0'
          />
        </form>
      </>
  );
};

export default FooterOne;
