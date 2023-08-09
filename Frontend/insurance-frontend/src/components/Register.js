import React, { useState } from 'react'
import { useNavigate } from 'react-router';


export const Register = (props) => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const navigate = useNavigate();
    const registerHandler = () =>{
      navigate('/');
    };
  return (
    <div className="form-container">
        <form className = "register-form">
            <label htmlFor='name'>Name</label>
            <input value ={name} onChange={(e)=> setName(e.target.value)} type="name" placeholder="Enter Your Name" id="name" name = "name"/>
            <label htmlFor='email'>Email</label>
            <input value={email} onChange={(e)=> setEmail(e.target.value)} type='email' placeholder='Enter your Email' id='email' name='email'/>
            <label htmlFor='password'>Password</label>
            <input value={password} onChange={(e)=> setPassword(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
            <label htmlFor='confirmPassword'>Confirm Password</label>
            <input value={confirmPassword} onChange={(e)=> setConfirmPassword(e.target.value)}type='password' placeholder="********" id="confirmPassword" name = "confirmPassword"/>
            <label htmlFor='phoneNumber'>Phone Number</label>
            <input value={phoneNumber} onChange={(e)=> setPhoneNumber(e.target.value)} type='phoneNumber' placeholder='Enter your Phone Number' id='phoneNumber' name='phoneNumber'/>
            <button className='submitBtn' onClick={()=>registerHandler()}> Submit </button>
        </form>
    </div>
  )
}