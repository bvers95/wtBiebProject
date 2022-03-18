import { LinkContainer } from 'react-router-bootstrap'
import { Button, Row, Col, Container } from 'react-bootstrap';

function NotFound() {
  return (
    <Container className="py-5">
      <Row>
        <Col className="text-center">
          <h3>Geen Pagina Gevonden</h3>
          <LinkContainer to="/">
            <Button className="mt-3 button-wt">Terug naar Home</Button>
          </LinkContainer>
        </Col>
      </Row>
    </Container>
    
  );
}

export default NotFound;
