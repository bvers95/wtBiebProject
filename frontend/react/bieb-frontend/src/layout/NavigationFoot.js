import { Navbar, Container } from 'react-bootstrap';

function NavigationFoot() {
  return (
    <Navbar 
      bg="dark" 
      variant="dark" 
      sticky="bottom" 
      className="py-4"
    >
      <Container>
        <Navbar.Text>
          Working Talent Bieb &#169; 2022
        </Navbar.Text>
      </Container>
    </Navbar>
  );
}

export default NavigationFoot;
