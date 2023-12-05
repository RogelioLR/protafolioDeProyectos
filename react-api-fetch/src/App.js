import { createTheme, ThemeProvider } from '@mui/material/styles';
import { blueGrey } from '@mui/material/colors';
import { CssBaseline } from '@mui/material';
import "./App.css";
import NavBarApp from './NavBar/NavBar';
import ButtonApp from './Boton/ButtonApp';


const theme = createTheme({
  palette: {
    background: {
      default: blueGrey[900],
    },
    primary: {
      main: blueGrey[700],
    },
    button: {
      main: blueGrey[500],
    }
  },
});

function App() {
  return (
    
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <NavBarApp
      src="./iconPage.png"
      theme={theme}
      />
      <ButtonApp 
      nameButton="Conoce Al Equipo"
      />
    </ThemeProvider>

  );
}

export default App;
