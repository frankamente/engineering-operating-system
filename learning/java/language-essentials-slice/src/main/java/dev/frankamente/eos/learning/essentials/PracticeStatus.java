package dev.frankamente.eos.learning.essentials;

public enum PracticeStatus {
  TODO,
  READY,
  IN_PROGRESS,
  DONE,
  BLOCKED;

  public boolean isOpen() {
    return switch (this) {
      case TODO, READY, IN_PROGRESS -> true;
      case DONE, BLOCKED -> false;
    };
  }

  public String nextAction() {
    return switch (this) {
      case TODO -> "prepare";
      case READY -> "start";
      case IN_PROGRESS -> "finish";
      case DONE -> "reflect";
      case BLOCKED -> "unblock";
    };
  }
}
