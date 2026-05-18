import "./Sidebar.css";

function Sidebar() {

  return (

    <div className="sidebar">

      <div className="logo">

        <h2>InternHub</h2>

      </div>

      <ul className="nav-links">

        <li>
          <a href="#" className="active">
            Interns
          </a>
        </li>

        <li>
          <a href="#">
            Projects
          </a>
        </li>

        <li>
          <a href="#">
            Attendance
          </a>
        </li>

        <li>
          <a href="#">
            Tasks
          </a>
        </li>

      </ul>

    </div>

  );

}

export default Sidebar;