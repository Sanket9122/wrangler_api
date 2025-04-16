package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDuration implements Token {
    private long milliseconds;

    public TimeDuration(String token) {
        Pattern pattern = Pattern.compile("(\\d+)([smh])");
        Matcher matcher = pattern.matcher(token);
        if (matcher.matches()) {
            long value = Long.parseLong(matcher.group(1));
            String unit = matcher.group(2);
            switch (unit) {
                case "s":
                    milliseconds = value * 1000;
                    break;
                case "m":
                    milliseconds = value * 60 * 1000;
                    break;
                case "h":
                    milliseconds = value * 60 * 60 * 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid TimeDuration token: " + token);
            }
        } else {
            throw new IllegalArgumentException("Invalid TimeDuration token: " + token);
        }
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    @Override
    public Object value() {
        return milliseconds;
    }

    @Override
    public TokenType type() {
        return TokenType.TIME_DURATION;
    }

    @Override
    public JsonElement toJson() {
        // Implement JSON conversion if needed
        return null;
    }
}
