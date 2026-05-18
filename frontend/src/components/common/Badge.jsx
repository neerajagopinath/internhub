import "../../styles/common/badge.css";

function Badge({ status }) {

    return (
        <span className={`status-badge ${status?.toLowerCase()}`}>
            {status}
        </span>
    );
}

export default Badge;