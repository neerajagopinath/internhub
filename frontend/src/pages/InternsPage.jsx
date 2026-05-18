import { useEffect, useState } from "react";

import Sidebar from "../components/layout/Sidebar";

import SearchBar from "../components/intern/SearchBar";

import InternCard from "../components/intern/InternCard";

import InternForm from "../components/intern/InternForm";

import {

  getAllInterns,
  createIntern,
  updateIntern,
  deleteIntern,
  searchInterns

} from "../services/internService";

import "../styles/interns.css";

function InternsPage() {

  const [interns, setInterns] = useState([]);

  const [loading, setLoading] = useState(false);
  const [editingId, setEditingId] = useState(null);

  const [searchTerm, setSearchTerm] = useState("");

  const [formData, setFormData] = useState({

    name: "",
    email: "",
    department: "",
    college: "",
    phone: "",
    joiningDate: "",
    status: "",

  });

  useEffect(() => {

    fetchInterns();

  }, []);

  const fetchInterns = async () => {

    try {

      const data = await getAllInterns();

      setInterns(data);

    }
    catch (error) {

      console.error(error);

    }

  };

  const handleChange = (event) => {

    setFormData({

      ...formData,

      [event.target.name]:
      event.target.value,

    });

  };

  const handleSubmit = async () => {

    try {

      setLoading(true);

      if (editingId) {

        await updateIntern(
          editingId,
          formData
        );

      }
      else {

        await createIntern(formData);

      }

      fetchInterns();

      setFormData({

        name: "",
        email: "",
        department: "",
        college: "",
        phone: "",
        joiningDate: "",
        status: "",

      });

      setEditingId(null);

    }
    catch (error) {

      console.error(error);

    }
    finally {

      setLoading(false);

    }

  };

  const handleEdit = (intern) => {

    setEditingId(intern.id);

    setFormData({

      name: intern.name,
      email: intern.email,
      department: intern.department,
      college: intern.college,
      phone: intern.phone,
      joiningDate: intern.joiningDate,
      status: intern.status,

    });

  };

  const handleDelete = async (id) => {

    try {

      await deleteIntern(id);

      fetchInterns();

    }
    catch (error) {

      console.error(error);

    }

  };

  const handleSearch = async () => {

    if (!searchTerm.trim()) {

      fetchInterns();

      return;

    }

    try {

      const data = await searchInterns(
        searchTerm
      );

      setInterns(data);

    }
    catch (error) {

      console.error(error);

    }

  };

  return (

    <div className="dashboard-container">

      <Sidebar />

      <div className="main-content">

        <div className="top-section">

          <h1 className="page-title">
            Interns
          </h1>

        </div>

        <SearchBar
          searchTerm={searchTerm}
          setSearchTerm={setSearchTerm}
          handleSearch={handleSearch}
        />

        <InternForm
          formData={formData}
          handleChange={handleChange}
          handleSubmit={handleSubmit}
          loading={loading}
          editingId={editingId}
        />

        <div className="intern-list">

          {
            interns.length === 0
            ? (
              <p>No interns found</p>
            )
            : (
              interns.map((intern) => (

                <InternCard
                  key={intern.id}
                  intern={intern}
                  handleDelete={handleDelete}
                  handleEdit={handleEdit}
                />

              ))
            )
          }

        </div>

      </div>

    </div>

  );

}

export default InternsPage;