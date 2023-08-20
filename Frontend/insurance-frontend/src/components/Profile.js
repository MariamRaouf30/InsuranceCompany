import React from 'react'
import { INFO } from './data/data'

function Profile() {

  return (
    <div className="profile-details">
      <div className="box">
        <strong>
          <label className="input-container" style={{ fontSize: '30px' }}>Profile Info</label>
        </strong>
        <br />
        <label>Name: {INFO.name}</label> 
        <br />
        <label>Email: {INFO.email}</label>
        <br />
        <label>Password: {INFO.password}</label>
        <br />
        <label>Phone Number: {INFO.phone_number}</label>
        <br />
      
               <div style={{ display: 'flex', justifyContent: 'center', position: 'fixed', bottom: '10px', width: '100%' }}>
               <button  style={{ backgroundColor: 'blue', color: 'white', padding: '10px 20px' }}>Edit Profile</button>
               </div>
            </div>
          </div>
  )
}

export default Profile
