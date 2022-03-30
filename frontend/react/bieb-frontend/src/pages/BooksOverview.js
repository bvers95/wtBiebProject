import { useState, useEffect } from 'react';
import { Row, Col, Container, Spinner, Alert } from 'react-bootstrap';

import OverviewList from '../components/overview/OverviewList';

import Config from "./../config.json";

function BooksOverview() {
  
  // Handles the states
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [books, setBooks] = useState([]);

  // Get all books
  useEffect(() => {
    setLoading(true);
    const fetchAllBooks = async () => {
      const rawData = await fetch(Config.DATABASE_URL + "api/books");
      const json = await rawData.json();
      setLoading(false);
      setBooks(json);
    };
    fetchAllBooks()
      .catch(error => {
        console.log(error);
        setLoading(false);
        setError(true);
      });
  }, []);
  
  if (loading) {
    return (
      <Container className="p-5">
        <Row>
          <Col className="text-center">
          <Spinner animation="border" role="status">
            <span className="visually-hidden">Loading...</span>
          </Spinner>
          </Col>
        </Row>
      </Container>
    );
  }

  if (error) {
    return (
      <Container className="p-5">
        <Row>
          <Col>
            <Alert variant="danger" className="mb-0">
              Er kan geen connectie gemaakt worden met de database...
            </Alert>
          </Col>
        </Row>
      </Container>
    );
  }

  return (
    <Container className="p-5">
      <Row>
        <Col>
          {'error' in books ? 
            <Alert variant="danger" className="mb-0">
              Probleem met ophalen van boeken uit database...
            </Alert> : 
            books.length === 0 ? 
              <section className="text-center">
                Geen boeken gevonden...
              </section> : 
              <OverviewList books={books}/>
          }
        </Col>
      </Row>
    </Container>
  );
}

export default BooksOverview;
