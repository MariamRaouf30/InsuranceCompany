import React, { useState } from 'react'


export const Register = (props) => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassowrd] = useState('');
    const [confirmPassword, setConfirmPassowrd] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
  return (
    <div className="form-container">
        <form className = "register-form">
            <label htmlFor='name'>Name</label>
            <input value ={name} onChange={(e)=> setName(e.target.value)} type="name" placeholder="Enter Your Name" id="name" name = "name"/>
            <label htmlFor='email'>Email</label>
            <input value={email} onChange={(e)=> setEmail(e.target.value)} type='email' placeholder='Enter your email' id='email' name='email'/>
            <label htmlFor='password'>Password</label>
            <input value={password} onChange={(e)=> setPassowrd(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
            <label htmlFor='confirmPassword'>Confirm Password</label>
            <input value={confirmPassword} onChange={(e)=> setConfirmPassowrd(e.target.value)}type='password' placeholder="********" id="confirmPassword" name = "confirmPassword"/>
            <label htmlFor='phoneNumber'>Phone Number</label>
            <input value={phoneNumber} onChange={(e)=> setPhoneNumber(e.target.value)} type='phoneNumber' placeholder='Enter your Phone Number' id='phoneNumber' name='phoneNumber'/>
        </form>
    </div>
  )
}
