import Input from "../common/Input";

import "../../styles/intern/search-toolbar.css";

function SearchToolbar({
    search,
    setSearch,
    status,
    setStatus,
    sortBy,
    setSortBy
}) {

    return (

        <div className="search-toolbar">

            <div className="toolbar-item">

                <Input
                    placeholder="Search interns..."
                    value={search}
                    onChange={(e) =>
                        setSearch(e.target.value)
                    }
                />

            </div>

            <div className="toolbar-item">

                <select
                    value={status}
                    onChange={(e) =>
                        setStatus(e.target.value)
                    }
                    className="toolbar-select"
                >

                    <option value="">
                        All Status
                    </option>

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

            </div>

            <div className="toolbar-item">

                <select
                    value={sortBy}
                    onChange={(e) =>
                        setSortBy(e.target.value)
                    }
                    className="toolbar-select"
                >

                    <option value="id">
                        Sort By ID
                    </option>

                    <option value="name">
                        Sort By Name
                    </option>

                    <option value="department">
                        Sort By Department
                    </option>

                    <option value="status">
                        Sort By Status
                    </option>

                </select>

            </div>

        </div>
    );
}

export default SearchToolbar;