package utils;

import day01.TaskD1;
import day02.TaskD2;
import day03.TaskD3;
import day04.TaskD4;
import day05.TaskD5;
import day06.TaskD6;
import day07.TaskD7;
import day08.TaskD8;

public enum Days {

	DAY1 {
		@Override
		public Task createTask() {
			return new TaskD1();
		}
	},
	DAY2 {
		@Override
		public Task createTask() {
			return new TaskD2();
		}
	},
	DAY3 {
		@Override
		public Task createTask() {
			return new TaskD3();
		}
	},
	DAY4 {
		@Override
		public Task createTask() {
			return new TaskD4();
		}
	},
	DAY5 {
		@Override
		public Task createTask() {
			return new TaskD5();
		}
	},
	DAY6 {
		@Override
		public Task createTask() {
			return new TaskD6();
		}
	},
	DAY7 {
		@Override
		public Task createTask() {
			return new TaskD7();
		}
	},
	DAY8 {
		@Override
		public Task createTask() {
			return new TaskD8();
		}
	};

	public abstract Task createTask();

}
