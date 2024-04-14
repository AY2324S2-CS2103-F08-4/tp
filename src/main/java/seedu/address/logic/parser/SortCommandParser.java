package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.TestNameEqualsKeywordPredicate;

/**
 * Parses input arguments and creates a new SortCommand object.
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public SortCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        boolean isReverse = trimmedArgs.contains("/r");
        // Remove the reverse flag from arguments if present and extract the test name.
        String testName = isReverse ? trimmedArgs.substring(0, trimmedArgs.length() - 2).trim() : trimmedArgs;

        if (testName.isEmpty()) {
            // In case the user inputs only "/r" without a test name
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }
        System.out.println(testName);
        System.out.println(isReverse);
        return new SortCommand(new TestNameEqualsKeywordPredicate(testName), isReverse);
    }
}
