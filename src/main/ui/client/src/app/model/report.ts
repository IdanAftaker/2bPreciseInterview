export class Report {
  pk: number | undefined;
  text: string | undefined;
  reportDate: Date | undefined;
  reporterPk: number;
  ownerPk: number | undefined;
}
