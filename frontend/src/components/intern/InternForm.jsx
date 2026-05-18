import { useEffect, useState } from "react";

import Input from "../common/Input";
import Button from "../common/Button";

import "../../styles/intern/intern-form.css";

function InternForm({
    initialData = null,
    onSubmit,
    onCancel
}) {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        department: "",
        college: "",
        phone: "",
        joiningDate: "",
        status: "ACTIVE"
    });

    useEffect(() => {

        if (initialData) {

            setFormData({
                name: initialData.name || "",
                email: initialData.email || "",
                department: initialData.department || "",
                college: initialData.college || "",
                phone: initialData.phone || "",
                joiningDate: initialData.joiningDate || "",
                status: initialData.status || "ACTIVE"
            });
        }

    }, [initialData]);

    function handleChange(event) {

        const { name, value } = event.target;

        setFormData((prev) => ({
            ...prev,
            [name]: value
        }));
    }

    function handleSubmit(event) {

        event.preventDefault();

        onSubmit(formData);
    }

    return (

        <form
            className="intern-form"
            onSubmit={handleSubmit}
        >

            <Input
                name="name"
                placeholder="Name"
                value={formData.name}
                onChange={handleChange}
            />

            <Input
                name="email"
                type="email"
                placeholder="Email"
                value={formData.email}
                onChange={handleChange}
            />

            <Input
                name="department"
                placeholder="Department"
                value={formData.department}
                onChange={handleChange}
            />

            <Input
                name="college"
                placeholder="College"
                value={formData.college}
                onChange={handleChange}
            />

            <Input
                name="phone"
                placeholder="Phone"
                value={formData.phone}
                onChange={handleChange}
            />

            <Input
                name="joiningDate"
                placeholder="Joining Date"
                value={formData.joiningDate}
                onChange={handleChange}
            />

            <select
                name="status"
                value={formData.status}
                onChange={handleChange}
                className="status-select"
            >
                <option value="ACTIVE">
                    ACTIVE
                </option>

                <option value="INACTIVE">
                    INACTIVE
                </option>

                <option value="COMPLETED">
                    COMPLETED
                </option>
            </select>

            <div className="form-buttons">

                <Button type="submit">
                    Save
                </Button>

                <Button
                    type="button"
                    variant="secondary"
                    onClick={onCancel}
                >
                    Cancel
                </Button>

            </div>

        </form>
    );
}

export default InternForm;