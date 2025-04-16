package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.parser.Directive;
import io.cdap.wrangler.api.parser.ExecutorContext;
import io.cdap.wrangler.api.parser.Row;
import io.cdap.wrangler.api.parser.Store;
import io.cdap.wrangler.api.parser.TokenGroup;

public class AggregateDirective implements Directive {
    private String sourceByteSizeColumn;
    private String sourceTimeDurationColumn;
    private String targetTotalSizeColumn;
    private String targetTotalTimeColumn;
    private String outputUnitSize;
    private String outputUnitTime;

    public AggregateDirective(String sourceByteSizeColumn, String sourceTimeDurationColumn,
                              String targetTotalSizeColumn, String targetTotalTimeColumn,
                              String outputUnitSize, String outputUnitTime) {
        this.sourceByteSizeColumn = sourceByteSizeColumn;
        this.sourceTimeDurationColumn = sourceTimeDurationColumn;
        this.targetTotalSizeColumn = targetTotalSizeColumn;
        this.targetTotalTimeColumn = targetTotalTimeColumn;
        this.outputUnitSize = outputUnitSize;
        this.outputUnitTime = outputUnitTime;
    }

    @Override
    public void define() {
        // Define the directive's arguments and their types
    }

    @Override
    public void execute(ExecutorContext context, Row row) {
        // Logic to read values from source columns, accumulate totals, and return new row
        Store store = context.getStore();
        // Read byte size and time duration values, accumulate, and perform conversions
    }

    // Additional methods for finalization and unit conversion can be added here
}
