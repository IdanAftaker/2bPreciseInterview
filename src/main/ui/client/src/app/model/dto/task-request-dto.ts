export class TaskRequestDTO {
  constructor(
    public assignDate: Date,
    public dueDate: Date,
    public description: string,
    public ownerPk: number
  ) {}
}
