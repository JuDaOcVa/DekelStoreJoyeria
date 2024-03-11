import create from "zustand";
import { StringFile } from "../../assets";
import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import { act } from "react-dom/test-utils";

describe("useStore", () => {
  it("should fetch data", async () => {
    const fetchMock = jest.fn().mockResolvedValue({
      json: jest.fn().mockResolvedValue({}),
    });
    global.fetch = fetchMock;
    const Component = () => {
      const { jsonData, loading, error, fetchData } = useStore();
      return (
        <div>
          <button onClick={fetchData}>fetch</button>
          {loading && <div>loading...</div>}
          {error && <div>error: {error.message}</div>}
          {jsonData && <pre>{JSON.stringify(jsonData, null, 2)}</pre>}
        </div>
      );
    };

    render(<Component />);

    await act(async () => {
      userEvent.click(screen.getByText("fetch"));
    });

    expect(fetchMock).toHaveBeenCalledWith(StringFile);
    expect(screen.queryByText("loading...")).toBeNull();
    expect(screen.queryByText("error:")).toBeNull();
    expect(screen.queryByText("jsonData")).not.toBeNull();
  });
});
