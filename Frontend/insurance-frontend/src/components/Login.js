import React, { useState } from 'react'
import { useNavigate } from 'react-router';
import { STATUS } from './status.js';
import {INFO} from './data/data.js'; 

const Login = () => {
  const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [customerId, setCustomerId] = useState(null);
    const loginHandler = async(event) =>{
      event.preventDefault();
      try {
        const response = await fetch(`http://localhost:8082/login/${name}`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
                    },
        });
        if (response.ok) {
          const arr = await response.json();
          console.log('Response arr String:', arr); 
          const data = JSON.parse(arr);
          console.log('Parsed Response:', data); 
          console.log('Customer ID:', data._id); 
          INFO.id = data._id;
          console.log('success');
          console.log(INFO.id);
          navigate('/');
          STATUS.isLogged =true;
      } else {
          console.log('unsuccessful');
      }
      } catch (error) {
          console.log('ERROR:', error);
      }
    };
    
  return (
    <div className="form-container" onSubmit={loginHandler}>
    <form className = "register-form">
        <label htmlFor='name'>Name</label>
        <input value={name} onChange={(e)=> setName(e.target.value)} type='name' placeholder='Enter your name' id='name' name='name'/>
        <label htmlFor='password'>Password</label>
        <input value={password} onChange={(e)=> setPassword(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
        <button className='submitBtn' onClick={(event)=>loginHandler(event)}> Submit </button>
        <label htmlFor = "Login">New Member?</label>
    <button className="link-btn" type= "Login" onClick={()=>navigate('/register')}>Register here.</button>
   
    </form>
    
</div>
)
  
  }

export default Login
