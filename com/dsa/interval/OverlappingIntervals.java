package com.dsa.interval;

import com.dsa.custom_class.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OverlappingIntervals {
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        List<Interval> result = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= start) {
                end = Math.max(end, current.end);
            } else {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start, end));
        intervals = result;
        return result;
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval current = intervals.get(i);
            newInterval.start = Math.min(current.start, newInterval.start);
            newInterval.end = Math.max(current.end, newInterval.end);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> overlapIntervals = new LinkedList<>();
        overlapIntervals.add(new Interval(7, 9));
        overlapIntervals.add(new Interval(1, 3));
        overlapIntervals.add(new Interval(2, 6));
        mergeIntervals(overlapIntervals);

        List<Interval> nonOverlapIntervals = new LinkedList<>();
        nonOverlapIntervals.add(new Interval(1, 3));
        nonOverlapIntervals.add(new Interval(5, 7));
        nonOverlapIntervals.add(new Interval(8, 10));
        nonOverlapIntervals.add(new Interval(4, 9));
        List<Interval> result =insert(nonOverlapIntervals, new Interval(4, 9));
        System.out.println(result);
    }
}
