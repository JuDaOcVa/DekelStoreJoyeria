import create from 'zustand';
import { StringFile } from '../../assets';

export const useStore = create((set) => ({
  jsonData: null,
  loading: true,
  error: null,
  fetchData: async () => {
    try {
      const response = await fetch(StringFile);
      const jsonData = await response.json();
      set({ jsonData, loading: false });
    } catch (error) {
      set({ error, loading: false });
    }
  },
}));
