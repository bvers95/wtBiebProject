import { LinkContainer } from 'react-router-bootstrap'
import { Button, Row, Col, Container } from 'react-bootstrap';

function NotFound() {
  return (
    <Container className="p-5">
      <Row>
        <Col className="text-center">
          <h4>Geen Pagina Gevonden</h4>
          <LinkContainer to="/">
            <Button className="mt-4 button-wt">Terug naar Home</Button>
          </LinkContainer>
        </Col>
      </Row>
    </Container>
    
  );
}

export default NotFound;
