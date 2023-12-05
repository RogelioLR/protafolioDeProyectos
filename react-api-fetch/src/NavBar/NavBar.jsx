import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { ThemeProvider } from '@emotion/react';



function NavBarApp(props) {

  return (
    <ThemeProvider theme={props.theme}>
    <AppBar position="static" color="primary">

      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <img src={props.src} alt='' width="35px"/>
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="#app-bar-with-responsive-menu"
            sx={{
              ml: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            Api Fetch Project
          </Typography>

          <Typography
            variant="h5"
            noWrap
            component="a"
            href="#app-bar-with-responsive-menu"
            sx={{
              ml: 2,
              display: { xs: 'flex', md: 'none' },
              fontFamily: 'monospace',
              fontWeight: 700,
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            Api Fetch Project
          </Typography>
          
        </Toolbar>
      </Container>
    </AppBar>
    </ThemeProvider>
  );
}
export default NavBarApp;