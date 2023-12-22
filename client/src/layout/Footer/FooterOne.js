import React, { useState } from 'react';
import axios from 'axios';

const FooterOne = () => {
  const [emailValue, setEmailValue] = useState('');
  const [loading, setLoading] = useState(false);

  const logMovies = async () => {
    setLoading(true);
    try {
      const response = await axios.post(
        'https://s7mvanfyy7726dco5yzt3emmsq0zeswn.lambda-url.us-east-1.on.aws/',
        { email: emailValue }
      );
      const result = response.data;
      console.log(result);
    } catch (error) {
      console.error('Error logging movies:', error.message);
      // Handle errors as needed
    } finally {
      setLoading(false);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    await logMovies();
  };

  return (
    <div className='newsletter-form position-relative d-block d-lg-flex d-md-flex'>
      <input
        type='text'
        className='input-newsletter form-control me-2'
        placeholder='Enter your email'
        name='email'
        required={true}
        autoComplete='off'
        onChange={(e) => setEmailValue(e.target.value)}
        value={emailValue}
      />
      <button onClick={handleSubmit} disabled={loading}>
        {loading ? 'Please wait...' : 'Subscribe'}
      </button>
    </div>
  );
};

export default FooterOne;
