import { Card, Col, Button } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap'

function OverviewItem (props) {
  return (
    <Col>
      <Card>
        <Card.Img variant="top" src="holder.js/100px160" />
        <Card.Body>
          <Card.Title>{props.title}</Card.Title>
          <LinkContainer to={"/book?isbn="+props.isbn}>
            <Button variant="primary">Bewerken</Button>
          </LinkContainer>
        </Card.Body>
      </Card>
    </Col>

  );
}

export default OverviewItem;
