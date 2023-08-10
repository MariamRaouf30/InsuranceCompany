import React from 'react'
import '@fortawesome/fontawesome-free/css/fontawesome.css';

const ContactUs = () => {
  return (
    <div className='contactScreen'>
    <div className='leftPane'>
      <h1 className='contactHeader'>Contact Information</h1>
      <p>
      &nbsp;&nbsp;&nbsp;&nbsp;You can always reach out to us
      </p>
      <div className='companyMail'>
      <svg width="20" height="16" viewBox="0 0 20 16" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M20 0H0V16H20V0ZM18 4L10 9L2 4V2L10 7L18 2V4Z" fill="white"/>
      </svg>

      &nbsp;contact@ininsurance.com
      </div>
      <div className='companyMobile'>
      <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M10 4.99999C12.103 4.99999 13 5.89699 13 7.99999H15C15 4.77499 13.225 2.99999 10 2.99999V4.99999ZM13.422 10.443C13.2299 10.2683 12.9774 10.1752 12.7178 10.1832C12.4583 10.1912 12.212 10.2998 12.031 10.486L9.63804 12.947C9.06204 12.837 7.90404 12.476 6.71204 11.287C5.52004 10.094 5.15904 8.933 5.05204 8.361L7.51104 5.96699C7.69745 5.78612 7.80617 5.53982 7.8142 5.2802C7.82222 5.02059 7.72892 4.76804 7.55404 4.57599L3.85904 0.512995C3.68408 0.320352 3.44092 0.203499 3.18119 0.187255C2.92146 0.17101 2.66564 0.256653 2.46804 0.425995L0.298038 2.28699C0.125149 2.46051 0.0219574 2.69145 0.00803782 2.93599C-0.00696218 3.18599 -0.292962 9.108 4.29904 13.702C8.30504 17.707 13.323 18 14.705 18C14.907 18 15.031 17.994 15.064 17.992C15.3086 17.9783 15.5394 17.8747 15.712 17.701L17.572 15.53C17.7415 15.3325 17.8273 15.0768 17.8113 14.817C17.7952 14.5573 17.6785 14.3141 17.486 14.139L13.422 10.443Z" fill="white"/>
      </svg>
      &nbsp;+01 23456789
      </div>
      <div className='location'>
      <svg width="17" height="22" viewBox="0 0 17 22" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M8.25001 0.5C6.06276 0.50258 3.96584 1.3726 2.41923 2.91922C0.872611 4.46584 0.00258913 6.56276 8.77716e-06 8.75C-0.00261089 10.5374 0.581244 12.2763 1.66201 13.7C1.66201 13.7 1.88701 13.9963 1.92376 14.039L8.25001 21.5L14.5793 14.0353C14.6123 13.9955 14.838 13.7 14.838 13.7L14.8388 13.6978C15.919 12.2747 16.5026 10.5366 16.5 8.75C16.4974 6.56276 15.6274 4.46584 14.0808 2.91922C12.5342 1.3726 10.4373 0.50258 8.25001 0.5ZM8.25001 11.75C7.65666 11.75 7.07665 11.5741 6.5833 11.2444C6.08995 10.9148 5.70543 10.4462 5.47837 9.89805C5.25131 9.34987 5.1919 8.74667 5.30765 8.16473C5.42341 7.58279 5.70913 7.04824 6.12869 6.62868C6.54825 6.20912 7.08279 5.9234 7.66474 5.80764C8.24668 5.69189 8.84988 5.7513 9.39806 5.97836C9.94624 6.20542 10.4148 6.58994 10.7444 7.08329C11.0741 7.57664 11.25 8.15666 11.25 8.75C11.249 9.54535 10.9326 10.3078 10.3702 10.8702C9.80784 11.4326 9.04535 11.749 8.25001 11.75Z" fill="white"/>
      </svg>
      &nbsp;123 Down Street, HomeTown Egypt
      </div>
    </div>
    <div className='rightPane'>
      <h1 className='rightHeader'>Fill out your message</h1>
      <label className='firstName'>
        First Name
      </label>
      <input className="input1" type="name" placeholder="First Name" id="name" name = "name"/>
      <label className='lastName'>Last Name</label>
      <input className="input2" type="name" placeholder="Last Name" id="name" name = "name"/>
      <div className='customerEmail'>
      <label className='mail'>Email</label>
      <input className="input3" type="name" placeholder="email@gmail.com" id="name" name = "name"/>
      </div>
      <div className='customerNumber'>
        
      <label className='number'>Phone Number</label>
      <input className="input4" type="name" placeholder="0123456789" id="name" name = "name"/>
      </div>
      <div className='message'>
      <label className='msg'>Enter your Message</label>
      <input className="input5" type="name" id="name" name = "name"/>
      </div>
      {/* <img src='../Picture2.png'
      class='msgPic'/> */}
      <button className='sendBtn' >Send Now</button> 
    </div>
    </div>
  )
}

export default ContactUs
