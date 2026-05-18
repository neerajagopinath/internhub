import "../../styles/common/button.css";

function Button({
    children,
    onClick,
    type = "button",
    variant = "primary",
    disabled = false
}) {

    return (
        <button
            type={type}
            onClick={onClick}
            disabled={disabled}
            className={`custom-button ${variant}`}
        >
            {children}
        </button>
    );
}

export default Button;