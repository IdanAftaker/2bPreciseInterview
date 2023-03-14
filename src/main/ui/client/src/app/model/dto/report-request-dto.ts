export class ReportRequestDTO {
  constructor(
    public text: string,
    public reportDate: Date,
    public reporterPk: number,
    public ownerPk: number
  ) {}
}
