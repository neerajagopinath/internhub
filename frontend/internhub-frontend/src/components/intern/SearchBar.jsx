function SearchBar({

  searchTerm,
  setSearchTerm,
  handleSearch

}) {

  return (

    <div className="search-box">

      <input
        type="text"
        placeholder="Search Intern by Name"
        value={searchTerm}
        onChange={(event) =>
          setSearchTerm(event.target.value)
        }
      />

      <button onClick={handleSearch}>
        Search
      </button>

    </div>

  );

}

export default SearchBar;