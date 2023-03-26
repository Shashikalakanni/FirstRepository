import React, { useEffect, useRef, useState } from 'react'
import { Link } from 'react-router-dom'
import Navbar from './Navbar'
import LoginDesign from './LoginDesign.png';
import Home from './Home';
import axios from "axios";
function Login() {

    let [userDetails, setUserDetails] = useState(null);
    let [error, setError] = useState(null);
    let userNameOrEmail = useRef();
    let password = useRef();

    useEffect(()=>{
        if(sessionStorage.getItem("userDetails")!=null)
        {
            let userDetails=sessionStorage.getItem("userDetails")
            userDetails=JSON.parse(userDetails)
            setUserDetails(userDetails)
        }
    },[])

    let handleLogin =  (e) => {
        e.preventDefault();
        setError(null)
        // fetch("http://localhost:8080/login", {
        //     method: "GET", headers: {
        //         userNameOrEmail: userNameOrEmail.current.value,
        //         password: password.current.value
        //     }
        // })
        //     .then((response) => {
        //         if (response.ok === true) {
        //             return response.json()
        //         }
        //         else {     
        //             console.log(response.status);               
        //         throw Error("Enter the correct details")
        //         }
        //     })
        //     .then((data) => { let userDetails=data; console.log(data); alert("Your Login Successful");
        //     setUserDetails(userDetails)
        //     let user=JSON.stringify(userDetails)
        //     sessionStorage.setItem("userDetails",user)})
        //     .catch((e) => { setError(e.message); console.log(error); alert("Enter correct values")})

        let header={headers: {
            usernameoremail: userNameOrEmail.current.value,
            password: password.current.value
        }}
       axios.get(`http://localhost:7071/login`,header)
            .then((response) => { let userDetails=response.data; console.log(response.data); alert("Your Login Successful");
            setUserDetails(userDetails)
            let user=JSON.stringify(userDetails)
            sessionStorage.setItem("userDetails",user)})
       .catch((response)=>{setError(response.response.data);alert("Enter correct values")})

                 
    }

return (
<>
    {userDetails===null &&     <div>
        <div> <Navbar /> </div>

        <div className='login'>

            <div className="form">
                <h1> Login </h1> <br />
                <h5>If You Are Already A Member, Easily Log In</h5>

                <form onSubmit={handleLogin}>
                    <input type="email text" placeholder="Username / Email id"  ref={userNameOrEmail} />
                    <input type="Password" placeholder="Password" ref={password} />
                    <button type='submit' >Login</button>
                </form>
                {error!==null && (<h4 className='error'>{error}</h4>)}
                <div className='gotofp'>
                    <Link to="/ForgotPass"> Forgot password?</Link>
                </div><br />

                _____________________________________________________

                <div className='gotosignup'>
                    <span>Don't have an Account ? </span>
                    <Link to="/signup" ><button>Sign Up</button> </Link> <br /><br />
                </div>

            </div>

            <div className='login_design'> <img src={LoginDesign} alt="No Design" /></div>

        </div>

    </div>}
    {userDetails!==null && <Home setUserDetails={setUserDetails}></Home>}
</>
);
}

export default Login;