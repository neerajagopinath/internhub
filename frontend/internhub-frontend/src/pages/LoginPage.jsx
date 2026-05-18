import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import { loginUser } from "../services/authService";

import "../styles/auth.css";

function LoginPage() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
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

      const response = await loginUser(formData);

      alert(response.message);

      navigate("/interns");

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

        <h2>Login</h2>

        <form onSubmit={handleSubmit}>

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
            placeholder="Enter Password"
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
              ? "Logging in..."
              : "Login"
            }

          </button>

        </form>

        <p>

          Don't have an account?

          <Link to="/signup">
            Sign Up
          </Link>

        </p>

      </div>

    </div>

  );

}

export default LoginPage;