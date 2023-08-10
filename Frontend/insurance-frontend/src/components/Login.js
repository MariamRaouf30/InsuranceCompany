import React, { useState } from 'react'
import { useNavigate } from 'react-router';

const Login = () => {
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
        <label htmlFor='email'>Email</label>
        <input value={email} onChange={(e)=> setEmail(e.target.value)} type='email' placeholder='Enter your Email' id='email' name='email'/>
        <label htmlFor='password'>Password</label>
        <input value={password} onChange={(e)=> setPassword(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
        <button className='submitBtn' onClick={()=>registerHandler()}> Submit </button>
        <label htmlFor = "Login">New Member?</label>
    <button className="link-btn" type= "Login" onClick={()=>navigate('/register')}>Register here.</button>
   
    </form>
    
</div>
)
  
}

export default Login
