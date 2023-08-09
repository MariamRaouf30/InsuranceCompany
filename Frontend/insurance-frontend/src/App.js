import './App.css';
import React from 'react';
import { Register } from './components/Register';
import Login from './components/Login';
import Home  from './components/Home';
import Navbar  from './components/Navbar';
import ContactUs from './components/ContactUs';
import Services from './components/Services';
import {Routes, Route,BrowserRouter as Router} from "react-router-dom";
import { Container } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/register" element={<Register />} />
      <Route path="/login" element={<Login />} />            
      <Route path="/contactUs" element={<ContactUs />} />     
      <Route path="/services" element={<Services />} />       
      </Routes>
    </Router>
  );
}

export default App;
