import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import { blueGrey } from '@mui/material/colors';
import { Box, LinearProgress } from '@mui/material';
import { useState } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Avatar from '@mui/material/Avatar';


const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: {sm:8, md:10},
    },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
        border: 0,
    },
}));


const delay = 3;
const url = "https://reqres.in/api/users?delay=" + delay;



const ColorButton = styled(Button)(({ theme }) => ({
    color: theme.palette.getContrastText(blueGrey[500]),
    backgroundColor: blueGrey[500],
    '&:hover': {
        backgroundColor: blueGrey[700],
    },
}));

const ButtonApp = (props) => {

    const [componentButton, setComponentButton] = useState();

    const handleButton = () => {
        setComponentButton(<LinearProgress />);

        const dataUsers = JSON.parse(localStorage.getItem("users"));
        const dateActual = new Date().getTime();

        const fetchUsers = async (url) => {
            await fetch(url)
                .then(response => response.json())
                .then(data => {
                    const users = data.data;
                    const dateClick = new Date().getTime();
                    localStorage.setItem("dateClick", dateClick);
                    localStorage.setItem("users", JSON.stringify(users));
                    showUsers(users);
                })
                .catch(error => console.log(error));
        };

        if (!dataUsers || (dateActual - localStorage.getItem("dateClick"))>60000) {
            fetchUsers(url);
        } else {
            showUsers(dataUsers);
        }
    };

    const showUsers = users => {
        setComponentButton(
            <TableContainer component={Paper}>
                <Table  aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell align="left">ID</StyledTableCell>
                            <StyledTableCell>Avatar</StyledTableCell>
                            <StyledTableCell align="left">First Name</StyledTableCell>
                            <StyledTableCell align="left">Last Name</StyledTableCell>
                            <StyledTableCell align="left">Email</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users.map((user) => (
                            <StyledTableRow key={user.id}>
                                <StyledTableCell align="left">{user.id}</StyledTableCell>
                                <StyledTableCell align="left">
                                    <Avatar alt="Avatar User" src={user.avatar} />
                                </StyledTableCell>
                                <StyledTableCell align="left">{user.first_name}</StyledTableCell>
                                <StyledTableCell align="left">{user.last_name}</StyledTableCell>
                                <StyledTableCell align="left">{user.email}</StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    };

    const ButtonComponent = 
        <Box>
            <Box m={5} display="flex" alignItems="center" justifyContent="center">
                <ColorButton variant="contained" onClick={handleButton} disabled={false}>{props.nameButton}</ColorButton>
            </Box>
            <Box ml={2} mr={2}>
                {componentButton}
            </Box>
        </Box>;

    return ButtonComponent;
};

export default ButtonApp;