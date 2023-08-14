import React, { useState } from 'react'
import { useNavigate } from 'react-router';
import { STATUS } from './status.js';

export const Register = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const navigate = useNavigate();
    const registerHandler = async(event) =>{
       event.preventDefault();
      // const customer = {name,password,email,phoneNumber}
      // console.log(customer);
      if (password !== confirmPassword) {
        alert("Passwords Do not match");
      } else {
        const formData = {
          name:name,
          password:password,
          phone_number:phoneNumber,
        };

        fetch('http://localhost:8081/register',{
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(formData)
        }).then(res => {
          if(res.ok){
            console.log("success")
            STATUS.isLogged = true;
            navigate('/');
          }
          else{
            console.log("unsuccessful");
            //console.log(res);
            throw new Error('Network response was not ok');
          }
             });
      }
    };
    
  return (
    <div className="form-container" >
        <form className = "register-form" onSubmit={registerHandler}>
            <label htmlFor='name'>Name</label>
            <input value ={name} onChange={(e)=> setName(e.target.value)} type="name" placeholder="Enter Your Name" id="name" name = "name"/>
            <label htmlFor='email'>Email</label>
            <input value={email} onChange={(e)=> setEmail(e.target.value)} type='email' placeholder='Enter your Email' id='email' name='email'/>
            <label htmlFor='password'>Password</label>
            <input value={password} onChange={(e)=> setPassword(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
            <label htmlFor='confirmPassword'>Confirm Password</label>
            <input value={confirmPassword} onChange={(e)=> setConfirmPassword(e.target.value)}type='password' placeholder="********" id="confirmPassword" name = "confirmPassword"/>
            <label htmlFor='phoneNumber'>Phone Number</label>
            <input value={phoneNumber} onChange={(e)=> setPhoneNumber(e.target.value)} type='tel' placeholder='Enter your Phone Number' id='phoneNumber' name='phoneNumber'/>
            <button className='submitBtn' onClick={(event)=>registerHandler(event)}> Submit </button>
            <label htmlFor = "Login">Already have an account?</label>
        <button className="link-btn" type= "Login" onClick={()=>navigate('/login')}>Login here.</button>
       
        </form>
        
    </div>
  )
}