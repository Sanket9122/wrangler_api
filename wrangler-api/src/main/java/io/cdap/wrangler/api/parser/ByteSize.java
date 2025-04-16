package io.cdap.wrangler.api.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteSize implements Token {
    private long bytes;

    public ByteSize(String token) {
        Pattern pattern = Pattern.compile("(\\d+)([KMG]B)?");
        Matcher matcher = pattern.matcher(token);
        if (matcher.matches()) {
            long value = Long.parseLong(matcher.group(1));
            String unit = matcher.group(2);
            if (unit != null) {
                switch (unit) {
                    case "KB":
                        bytes = value * 1024;
                        break;
                    case "MB":
                        bytes = value * 1024 * 1024;
                        break;
                    case "GB":
                        bytes = value * 1024 * 1024 * 1024;
                        break;
                    default:
                        bytes = value; // Assume bytes if no unit
                }
            } else {
                bytes = value; // Assume bytes if no unit
            }
        } else {
            throw new IllegalArgumentException("Invalid ByteSize token: " + token);
        }
    }

    public long getBytes() {
        return bytes;
    }

    @Override
    public Object value() {
        return bytes;
    }

    @Override
    public TokenType type() {
        return TokenType.BYTE_SIZE;
    }

    @Override
    public JsonElement toJson() {
        // Implement JSON conversion if needed
        return null;
    }
}
