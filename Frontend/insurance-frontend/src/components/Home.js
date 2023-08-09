import React from 'react'
import { useNavigate } from 'react-router'

const Home = () => {
  const navigate = useNavigate();
  return (
    <>
      <h1>Home</h1>
      <button onClick={()=>navigate("register")}>Hello</button>
    </>
  )
}

export default Home
