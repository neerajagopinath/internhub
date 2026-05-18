function InternForm({

  formData,
  handleChange,
  handleSubmit,
  loading,
  editingId

}) {

  return (

    <div className="form-box">

      <h3>

        {
          editingId
          ? "Edit Intern"
          : "Add New Intern"
        }

      </h3>

      <div className="input-group">

        <label>Name</label>

        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>Email</label>

        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>Department</label>

        <input
          type="text"
          name="department"
          value={formData.department}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>College</label>

        <input
          type="text"
          name="college"
          value={formData.college}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>Phone</label>

        <input
          type="text"
          name="phone"
          value={formData.phone}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>Joining Date</label>

        <input
          type="date"
          name="joiningDate"
          value={formData.joiningDate}
          onChange={handleChange}
        />

      </div>

      <div className="input-group">

        <label>Status</label>

        <input
          type="text"
          name="status"
          value={formData.status}
          onChange={handleChange}
        />

      </div>

      <button
        className="submit-btn"
        onClick={handleSubmit}
        disabled={loading}
      >

        {
          loading
          ? (
              editingId
              ? "Updating..."
              : "Adding..."
            )
          : (
              editingId
              ? "Update Intern"
              : "Add Intern"
            )
        }

      </button>

    </div>

  );

}

export default InternForm;