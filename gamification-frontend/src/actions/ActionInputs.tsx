import {
    TextInput
} from 'react-admin';
import { Divider, Box } from '@mui/material';

export const ActionInputs = () => {
    return (
        <Box flex="1" mt={-1}>
            <Box display="flex" width={430}>
                <TextInput source="actionName" fullWidth />
            </Box>
            <Divider />
        </Box>
    );
};

const Spacer = () => <Box width={20} component="span" />;
