import InternRow from "./InternRow";

import "../../styles/intern/intern-table.css";

function InternTable({
    interns,
    onEdit,
    onDelete
}) {

    return (

        <div className="intern-table-container">

            <table className="intern-table">

                <thead>

                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Department</th>
                        <th>College</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>

                </thead>

                <tbody>

                    {
                        interns.map((intern) => (

                            <InternRow
                                key={intern.id}
                                intern={intern}
                                onEdit={onEdit}
                                onDelete={onDelete}
                            />

                        ))
                    }

                </tbody>

            </table>

        </div>
    );
}

export default InternTable;