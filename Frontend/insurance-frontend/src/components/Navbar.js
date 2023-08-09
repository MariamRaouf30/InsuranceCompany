import React from 'react';
import { Container, Nav, Navbar as NavbarBs } from 'react-bootstrap';
import { NavLink, useNavigate } from 'react-router-dom';


const Navbar = () => {
  const navigate = useNavigate();
  const BarStyle = {
    background: '#3500A5',  // Set the background color to blue
    padding: '0 10px',     // Add some padding for spacing
    
  };
  const navBarStyle = ({ isActive }) => {
    return{
      marginRight: '37px',
      color: 'white', 
      textDecoration: isActive ? "underline" : "none",
      padding: "10px",
    }
  };
  const logo = {
    marginRight: '108px',
  };
  return (
   <nav style={BarStyle} >
    <div style={logo}>
    <svg width="187" height="68" viewBox="0 0 187 68" fill="none" xmlns="http://www.w3.org/2000/svg">
<g filter="url(#filter0_dd_104_2)">
<path d="M35.0823 59.9507C52.2486 59.9507 66.1646 46.5302 66.1646 29.9753C66.1646 13.4204 52.2486 0 35.0823 0C17.916 0 4 13.4204 4 29.9753C4 46.5302 17.916 59.9507 35.0823 59.9507Z" fill="#3500A5"/>
<path d="M35.0823 0C17.9167 0 4 13.4211 4 29.9753C4 42.6809 12.1863 53.5362 23.7494 57.903C23.468 55.5345 23.2378 51.8832 23.8517 49.2928C24.4145 46.949 27.4844 34.3914 27.4844 34.3914C27.4844 34.3914 26.5634 32.5905 26.5634 29.9507C26.5634 25.7812 28.5077 22.0724 31.6287 22.0724C34.2893 22.0724 36.1312 24.597 36.1312 26.8914C36.1312 29.4572 34.4427 33.3059 33.5474 36.8832C32.8055 39.8684 26.5634 66.7188 38.1521 42.3109C43.6779 42.3109 47.9245 36.6859 47.9245 28.5938C47.9245 21.4145 42.5779 16.4062 34.9288 16.4062C26.0774 16.4062 20.8842 22.7961 20.8842 29.4079C20.8842 31.9737 21.9075 34.7368 23.1866 36.2418C23.4424 36.5378 23.468 36.8092 23.3913 37.1053C23.161 38.0428 27.5867 33.972 27.4844 34.3914C27.3565 34.9342 21.4726 29.6793 20.8842 29.4079C15.1538 6.97133 23.1866 40.6579 23.1866 36.2418C23.1866 26.7928 18.1981 22.0724 31.6287 22.0724C42.3988 22.0724 54.8573 18.5526 54.8573 28.4704C54.8573 38.8076 57.2876 16.4062 47.9245 16.4062C44.7779 16.4062 32.6264 45.5428 31.6287 43.6678C31.6287 43.6678 30.0682 49.3914 29.6845 50.7977C28.9937 53.4128 27.1007 56.6694 25.8216 58.6678C28.7379 59.5312 31.8078 60 35.0311 60C52.1967 60 66.1134 46.5789 66.1134 30.0247C66.1646 13.4211 52.2479 0 35.0823 0Z" fill="white"/>
<g filter="url(#filter1_d_104_2)">
<path d="M70.896 44.152C70.864 43.2133 70.8373 42.344 70.816 41.544C70.8053 40.744 70.8 39.9547 70.8 39.176C70.8 38.3973 70.8053 37.6187 70.816 36.84C70.8373 36.0507 70.8693 35.208 70.912 34.312H73.616C73.5733 34.792 73.536 35.2773 73.504 35.768C73.8667 35.3093 74.2987 34.9307 74.8 34.632C75.3013 34.3227 75.8933 34.168 76.576 34.168C77.248 34.168 77.7973 34.28 78.224 34.504C78.6613 34.728 79.0027 35.0373 79.248 35.432C79.504 35.8267 79.6853 36.28 79.792 36.792C79.9093 37.2933 79.984 37.8373 80.016 38.424C80.048 39 80.064 39.5813 80.064 40.168C80.064 40.808 80.0533 41.4213 80.032 42.008C80.0107 42.5947 79.9893 43.0853 79.968 43.48C79.9467 43.8747 79.9307 44.1093 79.92 44.184H77.232C77.2533 43.7467 77.2747 43.2827 77.296 42.792C77.3173 42.2907 77.3387 41.8 77.36 41.32C77.3813 40.8293 77.392 40.3867 77.392 39.992C77.392 37.72 77.024 36.584 76.288 36.584C75.68 36.584 75.1253 36.8507 74.624 37.384C74.1333 37.9067 73.7227 38.568 73.392 39.368C73.392 39.4747 73.392 39.5813 73.392 39.688C73.392 40.2 73.392 40.7333 73.392 41.288C73.4027 41.832 73.4133 42.3547 73.424 42.856C73.4453 43.3467 73.4613 43.7733 73.472 44.136L70.896 44.152ZM92.9481 44.104C92.8628 43.5493 92.7881 42.8773 92.7241 42.088C92.6708 41.2987 92.6281 40.44 92.5961 39.512C92.5748 38.584 92.5641 37.64 92.5641 36.68C92.5641 35.4747 92.5855 34.3013 92.6281 33.16C92.6708 32.0187 92.7348 31.016 92.8201 30.152L95.7641 30.2C95.6468 30.9573 95.5561 31.848 95.4921 32.872C95.4388 33.896 95.4121 35.0587 95.4121 36.36C95.4121 37.6827 95.4335 39.0107 95.4761 40.344C95.5295 41.6773 95.5881 42.8987 95.6521 44.008L92.9481 44.104ZM97.3648 44.152C97.3328 43.2133 97.3061 42.344 97.2848 41.544C97.2741 40.744 97.2688 39.9547 97.2688 39.176C97.2688 38.3973 97.2741 37.6187 97.2848 36.84C97.3061 36.0507 97.3381 35.208 97.3808 34.312H100.085C100.042 34.792 100.005 35.2773 99.9728 35.768C100.335 35.3093 100.767 34.9307 101.269 34.632C101.77 34.3227 102.362 34.168 103.045 34.168C103.717 34.168 104.266 34.28 104.693 34.504C105.13 34.728 105.471 35.0373 105.717 35.432C105.973 35.8267 106.154 36.28 106.261 36.792C106.378 37.2933 106.453 37.8373 106.485 38.424C106.517 39 106.533 39.5813 106.533 40.168C106.533 40.808 106.522 41.4213 106.501 42.008C106.479 42.5947 106.458 43.0853 106.437 43.48C106.415 43.8747 106.399 44.1093 106.389 44.184H103.701C103.722 43.7467 103.743 43.2827 103.765 42.792C103.786 42.2907 103.807 41.8 103.829 41.32C103.85 40.8293 103.861 40.3867 103.861 39.992C103.861 37.72 103.493 36.584 102.757 36.584C102.149 36.584 101.594 36.8507 101.093 37.384C100.602 37.9067 100.191 38.568 99.8608 39.368C99.8608 39.4747 99.8608 39.5813 99.8608 39.688C99.8608 40.2 99.8608 40.7333 99.8608 41.288C99.8714 41.832 99.8821 42.3547 99.8928 42.856C99.9141 43.3467 99.9301 43.7733 99.9408 44.136L97.3648 44.152ZM112.8 44.328C112.075 44.328 111.403 44.2427 110.784 44.072C110.165 43.9013 109.605 43.6827 109.104 43.416C108.603 43.1493 108.155 42.8667 107.76 42.568L109.2 40.248C109.648 40.664 110.08 40.984 110.496 41.208C110.912 41.432 111.344 41.5867 111.792 41.672C112.251 41.7573 112.747 41.8 113.28 41.8C113.739 41.8 114.107 41.7413 114.384 41.624C114.661 41.496 114.8 41.336 114.8 41.144C114.8 40.984 114.667 40.8613 114.4 40.776C114.133 40.68 113.792 40.6 113.376 40.536C112.96 40.4613 112.523 40.3707 112.064 40.264C111.413 40.0933 110.805 39.896 110.24 39.672C109.675 39.448 109.216 39.144 108.864 38.76C108.523 38.376 108.352 37.864 108.352 37.224C108.352 36.712 108.475 36.264 108.72 35.88C108.965 35.4853 109.291 35.16 109.696 34.904C110.112 34.6373 110.581 34.44 111.104 34.312C111.627 34.184 112.165 34.12 112.72 34.12C113.68 34.12 114.507 34.2373 115.2 34.472C115.904 34.696 116.576 34.9947 117.216 35.368L115.76 37.576C115.44 37.352 115.072 37.16 114.656 37C114.251 36.8293 113.84 36.7013 113.424 36.616C113.019 36.52 112.64 36.472 112.288 36.472C111.904 36.472 111.6 36.5307 111.376 36.648C111.163 36.7653 111.056 36.9307 111.056 37.144C111.056 37.272 111.189 37.3947 111.456 37.512C111.733 37.6187 112.256 37.7627 113.024 37.944C113.483 38.0507 113.968 38.1627 114.48 38.28C114.992 38.3867 115.472 38.5413 115.92 38.744C116.379 38.936 116.747 39.2187 117.024 39.592C117.312 39.9547 117.456 40.44 117.456 41.048C117.456 42.072 117.045 42.872 116.224 43.448C115.403 44.0347 114.261 44.328 112.8 44.328ZM122.242 44.312C121.559 44.312 120.994 44.1893 120.546 43.944C120.109 43.7093 119.757 43.384 119.49 42.968C119.234 42.552 119.042 42.088 118.914 41.576C118.797 41.0533 118.717 40.5147 118.674 39.96C118.642 39.3947 118.626 38.8507 118.626 38.328C118.626 37.7307 118.642 37.1227 118.674 36.504C118.717 35.8853 118.759 35.208 118.802 34.472L121.73 34.296C121.698 34.52 121.65 34.856 121.586 35.304C121.522 35.752 121.463 36.264 121.41 36.84C121.357 37.416 121.33 38.0187 121.33 38.648C121.33 39.6827 121.421 40.4507 121.602 40.952C121.783 41.4427 122.055 41.688 122.418 41.688C123.143 41.688 123.677 41.16 124.018 40.104C124.359 39.048 124.53 37.3787 124.53 35.096V34.36L125.89 34.328L127.538 34.296C127.389 35.2987 127.277 36.2213 127.202 37.064C127.127 37.9067 127.079 38.616 127.058 39.192C127.037 39.7573 127.026 40.136 127.026 40.328C127.026 40.8187 127.069 41.1707 127.154 41.384C127.239 41.5867 127.389 41.688 127.602 41.688C127.709 41.688 127.826 41.6667 127.954 41.624C128.082 41.5813 128.231 41.5067 128.402 41.4L128.29 44.152C127.885 44.216 127.533 44.248 127.234 44.248C126.722 44.248 126.301 44.152 125.97 43.96C125.65 43.768 125.394 43.512 125.202 43.192C124.871 43.544 124.461 43.816 123.97 44.008C123.49 44.2107 122.914 44.312 122.242 44.312ZM129.657 44.248C129.7 43.3627 129.732 42.4773 129.753 41.592C129.774 40.7067 129.785 39.832 129.785 38.968C129.774 38.1787 129.758 37.4 129.737 36.632C129.726 35.8533 129.7 35.1013 129.657 34.376L132.345 34.296C132.356 34.6907 132.372 35.096 132.393 35.512C132.734 35.0853 133.129 34.744 133.577 34.488C134.036 34.2213 134.558 34.088 135.145 34.088C135.369 34.088 135.657 34.12 136.009 34.184C136.361 34.248 136.718 34.3707 137.081 34.552L136.777 37.256C136.51 37.096 136.222 36.984 135.913 36.92C135.614 36.8453 135.364 36.808 135.161 36.808C134.478 36.808 133.897 37.1173 133.417 37.736C132.948 38.344 132.628 39.192 132.457 40.28C132.457 41.0267 132.446 41.7413 132.425 42.424C132.414 43.096 132.388 43.704 132.345 44.248H129.657ZM141.753 44.264C140.953 44.264 140.227 44.056 139.577 43.64C138.926 43.2347 138.409 42.6853 138.025 41.992C137.651 41.288 137.465 40.504 137.465 39.64C137.465 38.8293 137.614 38.0987 137.913 37.448C138.211 36.7867 138.617 36.2213 139.129 35.752C139.651 35.2827 140.243 34.9253 140.905 34.68C141.566 34.424 142.259 34.296 142.985 34.296C143.593 34.296 144.19 34.3813 144.777 34.552C144.819 34.328 144.857 34.104 144.889 33.88L147.625 34.344C147.55 34.5467 147.475 34.8507 147.401 35.256C147.326 35.6613 147.262 36.1147 147.209 36.616C147.166 37.1173 147.129 37.6187 147.097 38.12C147.065 38.6213 147.049 39.0747 147.049 39.48C147.049 39.8107 147.07 40.136 147.113 40.456C147.166 40.7653 147.273 41.0213 147.433 41.224C147.593 41.416 147.838 41.512 148.169 41.512H148.393L147.993 44.296C147.289 44.296 146.707 44.1733 146.249 43.928C145.79 43.6933 145.422 43.3733 145.145 42.968C144.686 43.48 144.163 43.8213 143.577 43.992C142.99 44.1733 142.382 44.264 141.753 44.264ZM140.089 39.96C140.142 40.472 140.35 40.8827 140.713 41.192C141.086 41.4907 141.555 41.64 142.121 41.64C142.665 41.64 143.118 41.496 143.481 41.208C143.843 40.9093 144.142 40.504 144.377 39.992C144.366 39.8213 144.361 39.6453 144.361 39.464C144.361 39.0907 144.371 38.7067 144.393 38.312C144.414 37.9173 144.441 37.528 144.473 37.144C144.025 36.9733 143.555 36.888 143.065 36.888C142.489 36.888 141.971 37.0053 141.513 37.24C141.065 37.464 140.713 37.7787 140.457 38.184C140.201 38.5893 140.073 39.0587 140.073 39.592C140.073 39.656 140.073 39.72 140.073 39.784C140.073 39.848 140.078 39.9067 140.089 39.96ZM149.521 44.152C149.489 43.2133 149.462 42.344 149.441 41.544C149.43 40.744 149.425 39.9547 149.425 39.176C149.425 38.3973 149.43 37.6187 149.441 36.84C149.462 36.0507 149.494 35.208 149.537 34.312H152.241C152.198 34.792 152.161 35.2773 152.129 35.768C152.492 35.3093 152.924 34.9307 153.425 34.632C153.926 34.3227 154.518 34.168 155.201 34.168C155.873 34.168 156.422 34.28 156.849 34.504C157.286 34.728 157.628 35.0373 157.873 35.432C158.129 35.8267 158.31 36.28 158.417 36.792C158.534 37.2933 158.609 37.8373 158.641 38.424C158.673 39 158.689 39.5813 158.689 40.168C158.689 40.808 158.678 41.4213 158.657 42.008C158.636 42.5947 158.614 43.0853 158.593 43.48C158.572 43.8747 158.556 44.1093 158.545 44.184H155.857C155.878 43.7467 155.9 43.2827 155.921 42.792C155.942 42.2907 155.964 41.8 155.985 41.32C156.006 40.8293 156.017 40.3867 156.017 39.992C156.017 37.72 155.649 36.584 154.913 36.584C154.305 36.584 153.75 36.8507 153.249 37.384C152.758 37.9067 152.348 38.568 152.017 39.368C152.017 39.4747 152.017 39.5813 152.017 39.688C152.017 40.2 152.017 40.7333 152.017 41.288C152.028 41.832 152.038 42.3547 152.049 42.856C152.07 43.3467 152.086 43.7733 152.097 44.136L149.521 44.152ZM164.956 44.296C164.06 44.296 163.234 44.1093 162.476 43.736C161.719 43.3627 161.111 42.8293 160.652 42.136C160.194 41.432 159.964 40.5947 159.964 39.624C159.964 38.536 160.178 37.5813 160.604 36.76C161.031 35.9387 161.628 35.304 162.396 34.856C163.164 34.3973 164.06 34.168 165.084 34.168C166.066 34.168 166.898 34.3707 167.58 34.776C168.263 35.1707 168.871 35.8 169.404 36.664L167.18 38.2C166.882 37.72 166.578 37.3573 166.268 37.112C165.959 36.856 165.538 36.728 165.004 36.728C164.279 36.728 163.692 36.984 163.244 37.496C162.796 37.9973 162.572 38.6693 162.572 39.512C162.572 40.0027 162.69 40.4027 162.924 40.712C163.17 41.0213 163.468 41.2507 163.82 41.4C164.172 41.5493 164.503 41.624 164.812 41.624C165.132 41.624 165.442 41.5867 165.74 41.512C166.039 41.4267 166.322 41.2453 166.588 40.968C166.855 40.6907 167.095 40.2693 167.308 39.704L169.708 40.984C169.388 41.5707 169.031 42.1147 168.636 42.616C168.242 43.1173 167.751 43.5227 167.164 43.832C166.588 44.1413 165.852 44.296 164.956 44.296ZM175.6 44.28C174.576 44.28 173.675 44.0773 172.896 43.672C172.128 43.2773 171.525 42.7227 171.088 42.008C170.661 41.2933 170.448 40.4667 170.448 39.528C170.448 38.9627 170.544 38.3707 170.736 37.752C170.928 37.1227 171.237 36.536 171.664 35.992C172.091 35.448 172.651 35.0053 173.344 34.664C174.048 34.3227 174.901 34.152 175.904 34.152C176.629 34.152 177.237 34.232 177.728 34.392C178.229 34.552 178.635 34.76 178.944 35.016C179.264 35.272 179.504 35.544 179.664 35.832C179.835 36.12 179.947 36.3973 180 36.664C180.064 36.92 180.096 37.1333 180.096 37.304C180.096 38.3387 179.659 39.1387 178.784 39.704C177.92 40.2587 176.693 40.536 175.104 40.536C174.741 40.536 174.395 40.52 174.064 40.488C173.744 40.456 173.445 40.4187 173.168 40.376C173.371 40.9093 173.707 41.304 174.176 41.56C174.645 41.8053 175.131 41.928 175.632 41.928C176.357 41.928 176.997 41.8 177.552 41.544C178.107 41.2773 178.629 40.872 179.12 40.328L180.544 42.376C180.203 42.6533 179.819 42.9413 179.392 43.24C178.976 43.5387 178.464 43.784 177.856 43.976C177.248 44.1787 176.496 44.28 175.6 44.28ZM175.952 36.552C175.323 36.552 174.768 36.712 174.288 37.032C173.808 37.352 173.456 37.7733 173.232 38.296C173.499 38.3387 173.76 38.376 174.016 38.408C174.283 38.4293 174.544 38.44 174.8 38.44C175.035 38.44 175.301 38.4187 175.6 38.376C175.909 38.3333 176.208 38.2693 176.496 38.184C176.795 38.0987 177.04 37.992 177.232 37.864C177.424 37.7253 177.52 37.5653 177.52 37.384C177.52 37.2987 177.477 37.192 177.392 37.064C177.307 36.936 177.152 36.8187 176.928 36.712C176.704 36.6053 176.379 36.552 175.952 36.552Z" fill="white"/>
</g>
<ellipse cx="33.0596" cy="13" rx="5.18919" ry="5" fill="#3500A5"/>
</g>
<defs>
<filter id="filter0_dd_104_2" x="0" y="0" width="184.544" height="68" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB">
<feFlood flood-opacity="0" result="BackgroundImageFix"/>
<feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"/>
<feOffset dy="4"/>
<feGaussianBlur stdDeviation="2"/>
<feComposite in2="hardAlpha" operator="out"/>
<feColorMatrix type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.25 0"/>
<feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_104_2"/>
<feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"/>
<feOffset dy="4"/>
<feGaussianBlur stdDeviation="2"/>
<feComposite in2="hardAlpha" operator="out"/>
<feColorMatrix type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.25 0"/>
<feBlend mode="normal" in2="effect1_dropShadow_104_2" result="effect2_dropShadow_104_2"/>
<feBlend mode="normal" in="SourceGraphic" in2="effect2_dropShadow_104_2" result="shape"/>
</filter>
<filter id="filter1_d_104_2" x="66.8" y="30.1521" width="117.744" height="22.1758" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB">
<feFlood flood-opacity="0" result="BackgroundImageFix"/>
<feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"/>
<feOffset dy="4"/>
<feGaussianBlur stdDeviation="2"/>
<feComposite in2="hardAlpha" operator="out"/>
<feColorMatrix type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.25 0"/>
<feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_104_2"/>
<feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_104_2" result="shape"/>
</filter>
</defs>
</svg>
    </div>
    <NavLink style={navBarStyle} to="/">Home</NavLink>
    <NavLink style={navBarStyle} to="/contactUs">Contact Us</NavLink>
    <NavLink style={navBarStyle} to="/services">Our Services</NavLink>
    <div className='register-container'>
    <button className='register' onClick={()=>navigate("register")}>
      Join Us Now
      <svg
        width="16"
        height="16"
        viewBox="0 0 16 16"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
        style={{ marginLeft: '5px' }} // Adjust margin as needed
    >
        <path
            d="M11 7.99988H1"
            stroke="#3500A5"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        />
        <path
            d="M8.33337 10.6665L11.0004 7.99946L8.33337 5.33246"
            stroke="#3500A5"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        />
    </svg>
      </button>
    </div>
    </nav>
    
  );
};

export default Navbar;
