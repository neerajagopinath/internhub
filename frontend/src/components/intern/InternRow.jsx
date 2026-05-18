import Button from "../common/Button";
import Badge from "../common/Badge";

function InternRow({
    intern,
    onEdit,
    onDelete
}) {

    return (
        <tr>

            <td>{intern.name}</td>

            <td>{intern.email}</td>

            <td>{intern.department}</td>

            <td>{intern.college}</td>

            <td>
                <Badge status={intern.status} />
            </td>

            <td>
                <div className="action-buttons">

                    <Button
                        variant="secondary"
                        onClick={() => onEdit(intern)}
                    >
                        Edit
                    </Button>

                    <Button
                        variant="danger"
                        onClick={() => onDelete(intern.id)}
                    >
                        Delete
                    </Button>

                </div>
            </td>

        </tr>
    );
}

export default InternRow;