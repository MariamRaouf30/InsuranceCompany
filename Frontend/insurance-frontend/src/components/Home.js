import React from 'react'
import { useNavigate } from 'react-router'

const Home = () => {
  const navigate = useNavigate();
  return (
    <div className='homeContainer'>
    <div className="homeBackground"></div>
    <div className='home'>
      <h1 className='homeHeader'>Who are we? </h1>
      <p className='homeParagraph'>
      In Insurance is the leading Insurance company all over the world. 
      <br/>
      Our experts in insurance provide you with tailored solutions that match your needs, ensuring peace of mind for every stage of life.
      <br/>
      We ensure your Insurance. 
      Take a tour in our website and Explore how we put your well-being first.
      </p>
    </div>
    
    </div>
  )
}

export default Home
