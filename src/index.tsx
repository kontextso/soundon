import Soundon from './NativeSoundon';

export async function isSoundOn(): Promise<boolean> {
  return Soundon?.isSoundOn();
}
