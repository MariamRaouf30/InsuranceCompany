import React, { useState } from 'react'
import { useNavigate } from 'react-router';

const Login = () => {
  const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const navigate = useNavigate();
    const loginHandler = () =>{
       
      fetch('http://localhost:8090/api/customers/loginCustomer', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          name: name,
          password: password
        })
      }).then(async(res) => {
        if (res.ok) {
          console.log("success");
          // const data = await res.json();
          // localStorage.setItem('token', data.token); 
          navigate('/services');
        } else {
          console.log("unsuccessful");
         
          setEmail(''); 
          setPassword(''); 
        }
        return res.json();
      }).then((data) => {
        console.log(data);
        localStorage.setItem('token', data.token);
      }).catch(error => {
        console.log("ERROR");
      });
    };

  return (
    <div className="form-container" onSubmit={loginHandler}>
    <form className = "register-form">
        <label htmlFor='name'>Name</label>
        <input value={name} onChange={(e)=> setName(e.target.value)} type='name' placeholder='Enter your name' id='name' name='name'/>
        <label htmlFor='password'>Password</label>
        <input value={password} onChange={(e)=> setPassword(e.target.value)}type='password' placeholder="********" id="password" name = "password"/>
        <button className='submitBtn' onClick={()=>loginHandler()}> Submit </button>
        <label htmlFor = "Login">New Member?</label>
    <button className="link-btn" type= "Login" onClick={()=>navigate('/register')}>Register here.</button>
   
    </form>
    
</div>
)
  
  }

export default Login
