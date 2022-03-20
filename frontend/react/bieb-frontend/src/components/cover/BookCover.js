import { useState, useEffect } from 'react';

import { Spinner, Ratio } from 'react-bootstrap';

function BookCover (props) {
  
  // The automatic cover image
  const coverUrl = "https://covers.openlibrary.org/b/isbn/"+props.isbn+"-L.jpg";

  // Handles the states
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  // Preload cover
  useEffect(() => {
    const coverLoad = new Image();
    coverLoad.src = coverUrl;
    coverLoad.onload = () => {
      // Success but missing cover
      if (coverLoad.height <= 1) {
        setError(true);
      }
      setLoading(false);
    };
    coverLoad.onerror = () => {
      setLoading(false);
      setError(true);
    };
  }, []);

  const spinnerStyle = {
    position: "absolute",
    marginLeft: "-10px",
    marginTop: "-10px",
    left: "50%",
    top: "50%",
  };

  const coverError = {
    backgroundImage: "url('cover.png')",
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
    backgroundSize: "cover"
  }

  const coverSuccess = {
    backgroundImage: "url('"+coverUrl+"')",
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
    backgroundSize: "cover"
  }

  if (loading) {
    return (
      <Ratio className="cover-ratio">
        <div width="100%" height="100%">
          <Spinner animation="border" role="status" style={spinnerStyle}>
            <span className="visually-hidden">Loading...</span>
          </Spinner>
        </div>
      </Ratio>
    );
  }

  if (error) {
    return (
      <Ratio className="cover-ratio">
        <div style={coverError} className="rounded-top"></div>
      </Ratio>
    );
  }

  return (
    <Ratio className="cover-ratio">
      <div style={coverSuccess} className="rounded-top"></div>
    </Ratio>
  );
}

export default BookCover;