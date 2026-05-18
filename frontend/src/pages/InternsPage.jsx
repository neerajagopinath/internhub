import { useEffect, useState } from "react";

import {
    getAllInterns,
    searchInterns,
    deleteIntern,
    createIntern,
    updateIntern
} from "../services/internService";

import InternTable from "../components/intern/InternTable";
import SearchToolbar from "../components/intern/SearchToolbar";
import Pagination from "../components/intern/Pagination";
import InternForm from "../components/intern/InternForm";

import Loader from "../components/common/Loader";
import EmptyState from "../components/common/EmptyState";
import Modal from "../components/common/Modal";
import Button from "../components/common/Button";

import "../styles/pages/interns-page.css";

function InternsPage() {

    const [interns, setInterns] = useState([]);

    const [loading, setLoading] = useState(false);

    const [search, setSearch] = useState("");

    const [status, setStatus] = useState("");

    const [sortBy, setSortBy] =
        useState("id");

    const [currentPage, setCurrentPage] =
        useState(0);

    const [totalPages, setTotalPages] =
        useState(0);

    const [showCreateModal, setShowCreateModal] =
        useState(false);

    const [showEditModal, setShowEditModal] =
        useState(false);

    const [selectedIntern, setSelectedIntern] =
        useState(null);

    const pageSize = 5;

    useEffect(() => {

        fetchInterns();

    }, [
        currentPage,
        search,
        status,
        sortBy
    ]);

    async function fetchInterns() {

        try {

            setLoading(true);

            let response;

            if (search.trim() !== "") {

                response =
                    await searchInterns(
                        search,
                        currentPage,
                        pageSize,
                        sortBy,
                        "asc"
                    );

            } else {

                response =
                    await getAllInterns(
                        currentPage,
                        pageSize,
                        sortBy,
                        "asc"
                    );
            }

            let data = response.content;

            if (status !== "") {

                data =
                    data.filter(
                        (intern) =>
                            intern.status === status
                    );
            }

            setInterns(data);

            setTotalPages(response.totalPages);

        } catch (error) {

            console.error(
                "Failed to fetch interns",
                error
            );

        } finally {

            setLoading(false);
        }
    }

    async function handleCreate(formData) {

        try {

            await createIntern(formData);

            setShowCreateModal(false);

            fetchInterns();

        } catch (error) {

            console.error(
                "Failed to create intern",
                error
            );
        }
    }

    async function handleUpdate(formData) {

        try {

            await updateIntern(
                selectedIntern.id,
                formData
            );

            setShowEditModal(false);

            setSelectedIntern(null);

            fetchInterns();

        } catch (error) {

            console.error(
                "Failed to update intern",
                error
            );
        }
    }

    async function handleDelete(id) {

        const confirmed =
            window.confirm(
                "Are you sure you want to delete this intern?"
            );

        if (!confirmed) {
            return;
        }

        try {

            await deleteIntern(id);

            fetchInterns();

        } catch (error) {

            console.error(
                "Failed to delete intern",
                error
            );
        }
    }

    function handleEdit(intern) {

        setSelectedIntern(intern);

        setShowEditModal(true);
    }

    return (

        <div className="interns-page">

            <div className="interns-header">

                <h1>Intern Management</h1>

                <Button
                    onClick={() =>
                        setShowCreateModal(true)
                    }
                >
                    Add Intern
                </Button>

            </div>

            <SearchToolbar
                search={search}
                setSearch={setSearch}
                status={status}
                setStatus={setStatus}
                sortBy={sortBy}
                setSortBy={setSortBy}
            />

            {

                loading ? (

                    <Loader />

                ) : interns.length === 0 ? (

                    <EmptyState
                        message="No interns found"
                    />

                ) : (

                    <>

                        <InternTable
                            interns={interns}
                            onEdit={handleEdit}
                            onDelete={handleDelete}
                        />

                        <Pagination
                            currentPage={currentPage}
                            totalPages={totalPages}
                            onPageChange={setCurrentPage}
                        />

                    </>

                )
            }

            <Modal
                isOpen={showCreateModal}
                title="Create Intern"
                onClose={() =>
                    setShowCreateModal(false)
                }
            >

                <InternForm
                    onSubmit={handleCreate}
                    onCancel={() =>
                        setShowCreateModal(false)
                    }
                />

            </Modal>

            <Modal
                isOpen={showEditModal}
                title="Edit Intern"
                onClose={() => {
                    setShowEditModal(false);
                    setSelectedIntern(null);
                }}
            >

                <InternForm
                    initialData={selectedIntern}
                    onSubmit={handleUpdate}
                    onCancel={() => {
                        setShowEditModal(false);
                        setSelectedIntern(null);
                    }}
                />

            </Modal>

        </div>
    );
}

export default InternsPage;