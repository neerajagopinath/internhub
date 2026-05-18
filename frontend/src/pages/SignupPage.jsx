import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import { signupUser } from "../services/authService";

import "../styles/auth.css";

function SignupPage() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
  });

  const [loading, setLoading] = useState(false);

  const [error, setError] = useState("");

  const handleChange = (event) => {

    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });

  };

  const handleSubmit = async (event) => {

    event.preventDefault();

    setLoading(true);

    setError("");

    try {

      const response = await signupUser(formData);

      alert(response.message);

      navigate("/");

    }
    catch (err) {

      if (err.response && err.response.data.message) {

        setError(err.response.data.message);

      }
      else {

        setError("Something went wrong");

      }

    }
    finally {

      setLoading(false);

    }

  };

  return (

    <div className="auth-container">

      <div className="auth-box">

        <h2>Sign Up</h2>

        <form onSubmit={handleSubmit}>

          <input
            type="text"
            name="name"
            placeholder="Enter Name"
            value={formData.name}
            onChange={handleChange}
            required
          />

          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={formData.email}
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Create Password"
            value={formData.password}
            onChange={handleChange}
            required
          />

          {
            error &&
            <p className="error-text">
              {error}
            </p>
          }

          <button
            type="submit"
            disabled={loading}
          >

            {
              loading
              ? "Creating Account..."
              : "Sign Up"
            }

          </button>

        </form>

        <p>

          Already have an account?

          <Link to="/">
            Login
          </Link>

        </p>

      </div>

    </div>

  );

}

export default SignupPage;