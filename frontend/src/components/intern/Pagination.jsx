import Button from "../common/Button";

import "../../styles/intern/pagination.css";

function Pagination({
    currentPage,
    totalPages,
    onPageChange
}) {

    return (

        <div className="pagination-container">

            <Button
                variant="secondary"
                disabled={currentPage === 0}
                onClick={() => onPageChange(currentPage - 1)}
            >
                Previous
            </Button>

            <span>
                Page {currentPage + 1} of {totalPages}
            </span>

            <Button
                variant="secondary"
                disabled={currentPage + 1 >= totalPages}
                onClick={() => onPageChange(currentPage + 1)}
            >
                Next
            </Button>

        </div>
    );
}

export default Pagination;