import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import FooterOne from "../layout/Footer/FooterOne";

function index() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<FooterOne />} />
      </Routes>
    </BrowserRouter>
  );
}

export default index;
