function InternCard({

  intern,
  handleDelete,
  handleEdit

}) {

  return (

    <div className="intern-card">

      <div className="card-header">

        <h3>{intern.name}</h3>

        <div className="card-buttons">

          <button
            className="edit-btn"
            onClick={() => handleEdit(intern)}
          >
            Edit
          </button>

          <button
            className="delete-btn"
            onClick={() => handleDelete(intern.id)}
          >
            Delete
          </button>

        </div>

      </div>

      <div className="intern-details">

        <p>Email: {intern.email}</p>

        <p>Department: {intern.department}</p>

        <p>College: {intern.college}</p>

        <p>Phone: {intern.phone}</p>

        <p>Joining Date: {intern.joiningDate}</p>

        <p>Status: {intern.status}</p>

      </div>

    </div>

  );

}

export default InternCard;